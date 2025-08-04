function showCourses(){
    fetch("http://localhost:8080/course/available") //API End point
    .then((response) => response.json())
    .then((courses) => {
        const dataTable = document.getElementById("coursetable")

        courses.forEach(course => {
            var row = `<tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;
        });
    });
}

function showEnrolledStudents(){
    fetch("http://localhost:8080/course/enrolled")
    .then((response) => response.json())
    .then((students) => {
        const dataTable = document.getElementById("enrolledtable")
        dataTable.innerHTML = ''; // Clear existing content
        students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.courseName}</td>
            </tr>`
            dataTable.innerHTML += row;
        });
    })
    .catch(error => {
        console.error('Error fetching enrolled students:', error);
    });
}

document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registrationForm');
    if(form) {
        form.addEventListener('submit', async function(e) {
            e.preventDefault();
            
            const formData = new FormData(form);
            const searchParams = new URLSearchParams();
            
            // Append form data to URL parameters
            searchParams.append('name', formData.get('name'));
            searchParams.append('email', formData.get('email'));
            searchParams.append('courseName', formData.get('courseName'));

            try {
                const response = await fetch('http://localhost:8080/course/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: searchParams
                });

                const result = await response.text(); // Changed to text() as server returns String

                if (!response.ok) {
                    throw new Error(result || 'Registration failed');
                }

                console.log('Registration successful:', result);
                showNotification('Registration successful!');
                form.reset();
                
                // Wait for notification to show before redirecting
                setTimeout(() => {
                    window.location.href = 'enrolled.html';
                }, 2000);

            } catch (error) {
                console.error('Registration error:', error);
                showNotification(error.message || 'Registration failed. Please try again.', 'error');
            }
        });
    }
});

function showNotification(message, type = 'success') {
    const notification = document.getElementById('notification');
    notification.textContent = message;
    notification.style.backgroundColor = type === 'success' ? '#4CAF50' : '#f44336';
    notification.classList.add('show');
    
    setTimeout(() => {
        notification.classList.remove('show');
    }, 3000);
}
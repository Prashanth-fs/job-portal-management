<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - Post New Job</title>
    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body>

    <nav class="navbar">
        <div class="logo">Job Portal (Admin)</div>
        <div class="nav-links">
            <a href="admin-dashboard">Back to Dashboard</a>
            <a href="logout">Logout</a>
        </div>
    </nav>

    <div class="form-container">
        <div class="form-card">

            <h2>Post a New Job</h2>

            <form action="post-job" method="post" class="form-body">

                <div class="form-group">
                    <label>Job Title</label>
                    <input type="text" name="jobTitle" required />
                </div>

                <div class="form-group">
                    <label>Company Name</label>
                    <input type="text" name="companyName" required />
                </div>

                <div class="form-group">
                    <label>Location</label>
                    <input type="text" name="location" required />
                </div>

                <div class="form-group">
                    <label>Experience</label>
                    <input type="text" name="experience" required />
                </div>

                <div class="form-group">
                    <label>Skills</label>
                    <input type="text" name="skills" required />
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description" rows="4" required></textarea>
                </div>

                <button type="submit" class="form-btn">Post Job</button>

            </form>

        </div>
    </div>

</body>
</html>
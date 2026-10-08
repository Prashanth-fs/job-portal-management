<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Apply for Job - Job Portal</title>

    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body>

    <nav class="navbar">

        <div class="logo">
            Job Portal
        </div>

        <div class="nav-links">
            <a href="dashboard">Dashboard</a>
            <a href="./">Home</a>
        </div>

    </nav>


    <div class="dashboard-container">

        <h1 class="section-title">Job Application</h1>

        <div class="job-card">
        
<form action="submitApplication" method="post"
      enctype="multipart/form-data">
      
        <input type="hidden" name="jobId" value="${jobId}">
      

    <p>
        <label><b>Qualification:</b></label><br>
        <input type="text" name="qualification" required>
    </p>

    <p>
        <label><b>Experience:</b></label><br>
        <input type="text" name="experience" required>
    </p>

    <p>
        <label><b>Upload Resume:</b></label><br>
        <input type="file" name="resumeFile" required>
    </p>
    

    <br>

    <button type="submit" class="btn">
        Submit Application
    </button>

</form>

        </div>

    </div>

</body>
</html>
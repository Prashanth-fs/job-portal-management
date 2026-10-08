<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Details - Job Portal</title>

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

        <h1 class="section-title">
            ${jobTitle}
        </h1>

        <div class="job-card">

            <p>
                <b>Company:</b> ${companyName}
            </p>

            <p>
                <b>Location:</b> ${location}
            </p>

            <p>
                <b>Experience:</b> ${experience}
            </p>

            <p>
                <b>Skills Required:</b> ${skills}
            </p>

            <p>
                <b>Job Description:</b><br><br>

                ${description}
            </p>

            <br>

            <a href="apply?jobId=${jobId}" class="btn">
    Apply Now
</a>

        </div>

    </div>

</body>
</html>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - Dashboard</title>

    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body>

    <nav class="navbar">

        <div class="logo">
            Job Portal
        </div>

        <div class="nav-links">
            <a href="./">Home</a>
            <a href="logout">Logout</a>
        </div>

    </nav>


    <section class="dashboard-header">

        <h1>Welcome, ${users.userName} 👋</h1>

        <p>
            Find the latest opportunities and start your career journey.
        </p>

    </section>


    <main class="dashboard-container">

        <h2 class="section-title">
            Available Jobs
        </h2>


<div class="jobs-container">

    <c:forEach var="job" items="${jobs}">

        <div class="job-card">
            <h2>${job.jobTitle}</h2>
            <p><strong>Company:</strong> ${job.companyName}</p>
            <p><strong>Location:</strong> ${job.location}</p>
            <p><strong>Experience:</strong> ${job.experience}</p>
            <p><strong>Skills:</strong> ${job.skills}</p>
            <a href="jobDetails?jobId=${job.id}" class="btn">View Details</a>
        </div>

    </c:forEach>

</div>
       

    </main>


    <footer>
        <p>© 2026 Job Portal Management System</p>
    </footer>

</body>
</html>
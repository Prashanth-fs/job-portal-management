<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - Admin Dashboard</title>
    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body>

    <nav class="navbar">
        <div class="logo">Job Portal (Admin)</div>
        <div class="nav-links">
            <a href="post-job">Post New Job</a>
               <a href="view-applicants">View Applicants</a>
            <a href="logout">Logout</a>
        </div>
    </nav>

    <section class="dashboard-header">
        <h1>Welcome, Admin ${users.userName} 👋</h1>
        <p>Manage job postings for the portal.</p>
    </section>

    <main class="dashboard-container">
        <h2 class="section-title">Current Job Postings</h2>

        <div class="jobs-container">
            <c:forEach var="job" items="${jobs}">
                <div class="job-card">
                    <h2>${job.jobTitle}</h2>
                    <p><strong>Company:</strong> ${job.companyName}</p>
                    <p><strong>Location:</strong> ${job.location}</p>
                </div>
            </c:forEach>
        </div>

    </main>

</body>
</html>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - View Applicants</title>
    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #1e3a5f; color: white; }
    </style>
</head>

<body>

    <nav class="navbar">
        <div class="logo">Job Portal (Admin)</div>
        <div class="nav-links">
            <a href="admin-dashboard">Back to Dashboard</a>
            <a href="logout">Logout</a>
        </div>
    </nav>

    <main class="dashboard-container">
        <h2 class="section-title">All Applicants</h2>

        <c:if test="${empty applications}">
            <p>No applications have been submitted yet.</p>
        </c:if>

        <c:if test="${not empty applications}">
            <table>
                <tr>
                    <th>Applicant Name</th>
                    <th>Email</th>
                    <th>Job Applied For</th>
                    <th>Company</th>
                    <th>Qualification</th>
                    <th>Experience</th>
                    <th>Resume</th>
                </tr>

                <c:forEach var="app" items="${applications}">
                    <tr>
                        <td>${app.user.userName}</td>
                        <td>${app.user.email}</td>
                        <td>${app.job.jobTitle}</td>
                        <td>${app.job.companyName}</td>
                        <td>${app.qualification}</td>
                        <td>${app.experience}</td>
                        <td>
                            <a href="download-resume?applicationId=${app.applicationId}" class="btn">
                                Download
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </main>

</body>
</html>
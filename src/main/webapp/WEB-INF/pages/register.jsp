<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Portal - Register</title>

    <link rel="stylesheet" href="/JOB-Portal/css/style.css">
</head>

<body class="form-body">

    <nav class="navbar">

        <div class="logo">
            Job Portal
        </div>

        <div class="nav-links">
            <a href="./">Home</a>
            <a href="login">Login</a>
        </div>

    </nav>


    <div class="form-container">

        <div class="form-card">

            <h1>Create Account</h1>

            <p class="error-message">
    ${errorMsg}
</p>


            <form action="register" method="post">

                <div class="input-group">
                    <label>Full Name</label>
                    <input type="text"
                           name="userName"
                           placeholder="Enter your full name"
                           required>
                </div>


                <div class="input-group">
                    <label>Email Address</label>
                    <input type="email"
                           name="email"
                           placeholder="Enter your email"
                           required>
                </div>


                <div class="input-group">
                    <label>Mobile Number</label>
                    <input type="number"
                           name="mobile"
                           placeholder="Enter your mobile number"
                           required>
                </div>


                <div class="input-group">
                    <label>Password</label>
                    <input type="password"
                           name="password"
                           placeholder="Create a password"
                           required>
                </div>


                <button type="submit" class="btn form-btn">
                    Register
                </button>

            </form>


            <p class="bottom-text">
                Already have an account?
                <a href="login">Login Here</a>
            </p>

        </div>

    </div>

</body>
</html>
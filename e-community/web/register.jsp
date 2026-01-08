<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #ffffff;
            color: #000000;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .register-box {
            border: 1px solid #000;
            padding: 30px;
            width: 350px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            font-weight: normal;
            letter-spacing: 1px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #000;
            background: #fff;
            color: #000;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #000;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background: #333;
        }

        .message {
            margin-top: 10px;
            font-size: 14px;
        }

        .link {
            margin-top: 15px;
            display: block;
            color: #000;
            text-decoration: none;
            border: 1px solid #000;
            padding: 8px;
        }

        .link:hover {
            background: #000;
            color: #fff;
        }
    </style>
</head>

<body>

<div class="register-box">
    <h2>REGISTER</h2>

    <form action="registerServlet" method="post">
        <input type="text" name="fullName" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Create Account</button>
    </form>

    <div class="message">${message}</div>

    <a href="login.jsp" class="link">Back to Login</a>
</div>

</body>
</html>

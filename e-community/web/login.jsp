<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - EcoPortal</title>

    <style>
        /* Modern, organic color palette */
        :root {
            primary-green: #2d6a4f;
            light-green: #d8e2dc;
            background-soft: #f8f9f8;
            text-dark: #1b4332;
            accent-green: #40916c;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--background-soft);
            background-image: linear-gradient(135deg, #f8f9f8 0%, #e9f5db 100%);
            color: var(--text-dark);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-box {
            background: #ffffff;
            padding: 40px;
            width: 340px;
            text-align: center;
            border-radius: 15px; /* Softer, rounded corners */
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            border: 1px solid var(light-green);
        }

        h2 {
            margin-bottom: 25px;
            font-weight: 600;
            letter-spacing: 1.5px;
            color: var(primary-green);
            text-transform: uppercase;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1.5px solid var(light-green);
            border-radius: 8px;
            background: #fff;
            color: var(--text-dark);
            box-sizing: border-box; /* Ensures padding doesn't affect width */
            transition: border-color 0.3s ease;
        }

        input:focus {
            outline: none;
            border-color: var(--accent-green);
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 10px;
            background: var(primary-green);
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            transition: background 0.3s ease;
        }

        button:hover {
            background: accent-green;
        }

        .register-link {
            margin-top: 20px;
            font-size: 14px;
        }

        .register-link a {
            color: var(accent-green);
            text-decoration: none;
            font-weight: bold;
        }

        .register-link a:hover {
            text-decoration: underline;
        }

        .error {
            margin-top: 15px;
            color: #bc4749;
            font-size: 14px;
        }
    </style>
</head>

<body>

<div class="login-box">
    <h2>Welcome Back</h2>

    <form action="loginServlet" method="post">
        <input type="email" name="email" placeholder="Email Address" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <div class="register-link">
        Don't have an account? <a href="register.jsp">Register here</a>
    </div>

    <div class="error">${message}</div>
</div>

</body>
</html>
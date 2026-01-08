<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dashboard - EcoPortal</title>
    <style>
        :root {
            primary-green: #2d6a4f;
            light-green: #d8e2dc;
            background-soft: #f8f9f8;
            text-dark: #1b4332;
        }

        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f8f9f8;
            margin: 0;
            display: flex;
        }

        /* Sidebar Navigation */
        .sidebar {
            width: 250px;
            height: 100vh;
            background: #2d6a4f;
            color: white;
            padding: 20px;
            position: fixed;
        }

        .sidebar h2 { font-size: 1.2rem; border-bottom: 1px solid rgba(255,255,255,0.2); padding-bottom: 10px; }
        .sidebar ul { list-style: none; padding: 0; }
        .sidebar ul li { margin: 20px 0; }
        .sidebar ul li a { color: white; text-decoration: none; font-weight: 500; }

        /* Main Content */
        .main-content {
            margin-left: 270px;
            padding: 40px;
            width: 100%;
        }

        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 40px;
        }

        .stat-card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            border-bottom: 4px #2d6a4f;
            box-shadow: 0 4px 6px rgba(0,0,0,0.05);
            text-align: center;
        }

        .stat-card h3 { color: #1b4332; margin: 0; font-size: 1rem; }
        .stat-card p { font-size: 2rem; font-weight: bold; color: #2d6a4f; margin: 10px 0 0; }
    </style>
</head>
<body>

<div class="sidebar">
    <h2>Eco Community</h2>
    <ul>
        <li><a href="eventServlet?action=list">Volunteer Events</a></li>
        <li><a href="eventServlet?action=new">Create Event</a></li>
        <li><a href="profile.jsp">My Profile</a></li>
        <li><a href="logoutServlet" style="color: #ffadad;">Logout</a></li>
    </ul>
</div>

<div class="main-content">
    <h1>Welcome, ${sessionScope.user.fullName}!</h1>
    <p>Real-time community impact overview.</p>

    <div class="stats-grid">
        <div class="stat-card">
            <h3>Active Programs</h3>
            <p>${eventCount != null ? eventCount : 0}</p>
        </div>

        <div class="stat-card">
            <h3>Total Volunteers</h3>
            <p>${userCount != null ? userCount : 0}</p>
        </div>

        <div class="stat-card">
            <h3>Hours Contributed</h3>
            <p>${hourCount != null ? hourCount : 0}</p>
        </div>
    </div>
</div>

</body>
</html>
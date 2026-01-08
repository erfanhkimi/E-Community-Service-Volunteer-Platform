<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create Volunteer Event - EcoPortal</title>
    <style>
        :root {
            primary-green: #2d6a4f;
            light-green: #d8e2dc;
            background-soft: #f8f9f8;
            text-dark: #1b4332;
            accent-green: #40916c;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, var(background-soft) 0%, #e9f5db 100%);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            color: var(--text-dark);
        }

        .form-container {
            background: #ffffff;
            padding: 40px;
            width: 450px;
            border-radius: 20px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.08);
            border: 1px solid var(light-green);
        }

        h2 {
            color: var(primary-green);
            margin-bottom: 10px;
            font-size: 24px;
        }

        p {
            font-size: 14px;
            color: #666;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            font-size: 14px;
        }

        input, textarea, select {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1.5px solid var(light-green);
            border-radius: 10px;
            background: #fafafa;
            box-sizing: border-box;
            font-family: inherit;
        }

        input:focus, textarea:focus {
            outline: none;
            border-color: var(accent-green);
            background: #fff;
        }

        .btn-save {
            width: 100%;
            padding: 14px;
            background: var(primary-green);
            color: #fff;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            transition: all 0.3s ease;
        }

        .btn-save:hover {
            background: var(accent-green);
            transform: translateY(-2px);
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: var(accent-green);
            text-decoration: none;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Create New Event</h2>
    <p>Organize a new volunteer activity for the community.</p>

    <form action="eventServlet" method="post">
        <label>Event Name</label>
        <input type="text" name="eventName" placeholder="e.g., Riverside Clean-up" required>

        <label>Date</label>
        <input type="date" name="eventDate" required>

        <label>Location</label>
        <input type="text" name="location" placeholder="e.g., Central Park" required>

        <label>Description</label>
        <textarea name="description" rows="4" placeholder="Briefly describe the goals of this event..."></textarea>

        <button type="submit" class="btn-save">Publish Event</button>
    </form>

    <a href="event_list.jsp" class="back-link">← Cancel and return to list</a>
</div>

</body>
</html>
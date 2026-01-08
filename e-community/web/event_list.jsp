<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Volunteer Events - EcoPortal</title>
    <style>
        :root { --primary-green: #2d6a4f; --accent-green: #40916c; --bg: #f8f9f8; }
        body { font-family: 'Segoe UI', sans-serif; background: var(--bg); padding: 40px; }
        .container { max-width: 900px; margin: auto; background: white; padding: 30px; border-radius: 15px; box-shadow: 0 5px 15px rgba(0,0,0,0.05); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { background: #d8e2dc; color: var(--primary-green); padding: 15px; text-align: left; }
        td { padding: 15px; border-bottom: 1px solid #eee; }
        
        /* Eco-friendly Button Styles */
        .btn { padding: 8px 15px; border-radius: 5px; text-decoration: none; font-size: 14px; font-weight: bold; }
        .btn-join { background: var(--primary-green); color: white; }
        .btn-edit { background: #ffca3a; color: #333; }
        .btn-delete { background: #ff595e; color: white; }
    </style>
</head>
<body>

<div class="container">
    <h2>Available Volunteer Programs</h2>
    <p>Logged in as: <strong>${sessionScope.user.role}</strong></p>

    <table>
        <thead>
            <tr>
                <th>Event Name</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>${event.eventName}</td>
                    <td>${event.eventDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sessionScope.user.role == 'Admin'}">
                                <a href="event_edit.jsp?id=${event.id}" class="btn btn-edit">Edit</a>
                                <a href="eventList?action=delete&id=${event.id}" 
                                   class="btn btn-delete" onclick="return confirm('Delete this event?')">Delete</a>
                            </c:when>
                            <c:otherwise>
                                <form action="joinEvent" method="post" style="display:inline;">
                                    <input type="hidden" name="eventId" value="${event.id}">
                                    <button type="submit" class="btn btn-join">Join Event</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <c:if test="${sessionScope.user.role == 'Admin'}">
        <br><a href="event_create.jsp" style="color: var(--primary-green);">+ Create New Event</a>
    </c:if>
</div>

</body>
</html>
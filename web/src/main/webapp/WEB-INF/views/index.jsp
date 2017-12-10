<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
	<title>Bead1 Főoldal</title>
	<meta charset="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="../css/main.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>
    </head>
    <body>
	<div id="maindiv">
	    <div><img src="../img/header.png" id="headerpic" alt="Címsor kép"/></div>
	    <div>
		<ul id="menu">
		    <li style="float:left"><a class="menuitem" href="index.html">Main Page</a></li>
		    <li style="float:left"><a class="menuitem" href="index.html">Main Page</a></li>
		    <li style="float:left"><a class="menuitem" href="index.html">Main Page</a></li>
		</ul>
	    </div>
	    <div id="spacer"></div>

	    <div id="bodydiv">
		<h1 id="pencilcaseheader">Maintenance center</h1>
		<p>Below you can see your pencil cases with the pencils in each one. You can add new pencil
		cases, delete them, and you can add pencils to each of them. To add a new pencil to a case,
		click on the "New pencil" button and than set the properties of the new pencil. Once you are
		done, click the add button.
		Then you can use your pencils, sharpen them or even break them. The length of them will
		decrease accordingly.</p>
		<button id="newpencilcasebutton" onclick="addPencilCase()">New pencil case</button>
		<br/>
		<c:forEach items="${allPencilCase}" var="PencilCase">
		    <div class="pencilcase">
			<button class="newpencilbutton" onclick="newPencil(this)">New pencil</button>
			<button class="deletecasebutton" onclick="deletePencilCase(this)">Delete case</button>
			<div class="newfield" style="display:none">
			    <h2>New pencil</h2>
			    <form class="newform">
				<input type="hidden" name="pencilCaseId" value="<c:out value="${PencilCase.id}"/>"/>
				<select name="color">
				    <c:forEach items="${allColor}" var="Color">
					<option value="${Color.toString()}">${Color.toString()}</option>
				    </c:forEach>
				</select><br/>
				<input type="text" name="brand" value="Brand"/><br/>
				Length:
				<input type="range" name="length"/><br/>
				Sharpness:
				<input type="range" name="sharpness"/><br/>
				<input class="addpencilbutton" type="button" value="Add" onclick="addPencil(this)"/>
			    </form>
			</div>
			<c:forEach items="${PencilCase.pencils}" var="Pencil">
			    <div class="pencil">
				<input type="hidden" name="pencilId" value="<c:out value="${Pencil.id}"/>"/>
				<div><c:out value="${Pencil.color}"/></div>
				<div><c:out value="${Pencil.brand}"/></div>
				<div class="left">Length: </div>
				<div class="right"><c:out value="${Pencil.length}"/></div>
				<div></div>
				<div class="left">Sharpness: </div>
				<div class="right"><c:out value="${Pencil.sharpness}"/></div>
				<div></div>
				<button class="deletebutton" onclick="deletePencil(this)">Delete</button>
				<button class="sharpenbutton" onclick="sharpenPencil(this)">Sharpen</button>
				<button class="usebutton" onclick="usePencil(this)">Use</button>
				<button class="brakeButton" onclick="brakePencil(this)">Brake</button>
				<div class="percentagefield" style="display:none">
				    <input type="range" name="percentage"/>
				    <button class="sendbutton" onclick="sendPencil(this)">Send</button>
				</div>
			    </div>
			</c:forEach>
		    </div>
		</c:forEach>
	    </div>
	</div>
    </body>
</html>

<!doctype html>
<html>
	<head>
		<title>My cool web site</title>
	</head>
	<body>
		<h1>My cool web site</h1>
		<g:link controller="category">CRUD categories</g:link> |
		<g:link controller="item">CRUD items</g:link> | 
		<g:link controller="photo">CRUD photos</g:link>
		
		<br/>
		<div id="map">Yo debería ser un mapica guapo</div>
		
		<br/><br/>
		<g:if test="${sites}">
			<g:each in="${sites}" var="site">
			<div>
			<strong>${site.name}</strong> (${site.category})
			<br/>
			${site.place}
			<br/>
			<g:nl2br text="${site.description}"/>
			
				<g:if test="${site.photos}">
				<g:each in="${site.photos}" var="photo">
				<div>
					<bi:img size="large" bean="${photo}" alt="${photo.name}" title="${photo.name}"/>
				</div>
				</g:each>
				</g:if>
			</div>
			<hr/>
			</g:each>
		</g:if>
		
	</body>
</html>
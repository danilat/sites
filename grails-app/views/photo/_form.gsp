<%@ page import="sites.Photo" %>



<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'imageExtension', 'error')} ">
	<label for="file">
		<g:message code="photo.image.label" default="Image" />
		
	</label>
	<input type="file" name="file" />
</div>

<div class="fieldcontain ${hasErrors(bean: photoInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="photo.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${photoInstance?.name}"/>
</div>


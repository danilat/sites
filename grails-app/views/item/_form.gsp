<%@ page import="sites.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${itemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="item.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${itemInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'place', 'error')} ">
	<label for="place">
		<g:message code="item.place.label" default="Place" />
		
	</label>
	<g:textField name="place" value="${itemInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="item.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="category" name="category.id" from="${sites.Category.list()}" optionKey="id" required="" value="${itemInstance?.category?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'photo', 'error')} ">
	<label for="photo">
		<g:message code="item.photo.label" default="Photo" />
		
	</label>
	<g:select name="photo" from="${sites.Photo.list()}" multiple="multiple" optionKey="id" size="5" value="${itemInstance?.photo*.id}" class="many-to-many"/>
</div>


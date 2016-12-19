<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal fade" id="validationModal" tabindex="-1" role="dialog"
	aria-labelledby="validationModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Fermer">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="validationModalLabel">Confirmation</h4>
			</div>
			<div class="modal-body">
				<c:out value="${action}" default="pb" />&nbsp;
				<c:out value="${entityName}"/>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
				<button type="button" class="btn btn-primary odom-submit">Enregistrer
				</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('body').on('click', '.odom-submit', function(e) {
			$(this.form).submit();
			$('#validationModal').modal('hide');
		});
	});
</script>

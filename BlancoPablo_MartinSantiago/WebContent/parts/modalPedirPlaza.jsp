<!-- Modal -->
<div class="modal fade" id="pedirPlaza" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Pedir plaza</h4>
			</div>
			<div class="modal-body">
				<form action="pedirPlaza?id=${ viaje.id }" method="post">
					<input type="text" name="comentario" placeholder="comentario"> 
					<input type="submit" value="Pedir plaza">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			</div>
		</div>
	</div>
</div>
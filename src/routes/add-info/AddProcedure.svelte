<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const procedure = {
			procNum: document.getElementById('pnum')?.value,
			name: document.getElementById('pname')?.value,
			description: document.getElementById('pdes')?.value,
			offeredBy: document.getElementById('pdep')?.value,
			duration: document.getElementById('')?.value
		};

		const response = await fetch('http://localhost:8080/add-procedure', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(procedure)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<form on:submit={handleSubmit}>
	<div class="form-group">
		<label for="pnum">Procedure Number: </label>
		<input type="text" name="pnum" id="pnum" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pname">Name: </label>
		<input type="text" name="pname" id="pname" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pdep">Department Code: </label>
		<input type="text" name="pdep" id="pdep" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pdes">Description: </label>
		<input type="text" name="pdes" id="pdes" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pdur">Duration: </label>
		<input type="text" name="pdur" id="pdur" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

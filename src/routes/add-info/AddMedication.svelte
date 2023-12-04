<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const medication = {
			name: document.getElementById('mname')?.value,
			manufacturer: document.getElementById('mmanu')?.value,
			description: document.getElementById('mdes')?.value
		};

		const response = await fetch('http://localhost:8080/add-medication', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(medication)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<form on:submit={handleSubmit}>
	<div class="form-group">
		<label for="mname">Name: </label>
		<input type="text" name="mname" class="form-control" id="mname" />
	</div>

	<div class="form-group">
		<label for="mmanu">Manufacturer: </label>
		<input type="text" name="mmanu" id="mmanu" class="form-control" />
	</div>

	<div class="form-group">
		<label for="mdes">Description: </label>
		<input type="textbox" name="mdes" id="mdes" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

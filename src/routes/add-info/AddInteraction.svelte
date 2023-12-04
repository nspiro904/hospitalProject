<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const interaction = {
			pssn: document.getElementById('ipatient')?.value,
			id: document.getElementById('iid')?.value,
			date: document.getElementById('idate')?.value,
			description: document.getElementById('ides')?.value,
			time: document.getElementById('itime')?.value
		};

		const response = await fetch('http://localhost:8080/add-interaction', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(interaction)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<form on:submit={handleSubmit}>
	<div class="form-group">
		<label for="ipatient">Patient ID (P########): </label>
		<input type="text" name="ipatient" id="ipatient" class="form-control" />
	</div>
	<div class="form-group">
		<label for="iid">Interaction ID: </label>
		<input type="text" name="iid" id="iid" class="form-control" />
	</div>
	<div class="form-group">
		<label for="idate">Date (MM-DD-YYYY): </label>
		<input type="text" name="ddate" id="ddate" class="form-control" />
	</div>
	<div class="form-group">
		<label for="itime">Time: </label>
		<input type="text" name="itime" id="itime" class="form-control" />
	</div>
	<div class="form-group">
		<label for="ides">Description: </label>
		<input type="text" name="ides" id="ides" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

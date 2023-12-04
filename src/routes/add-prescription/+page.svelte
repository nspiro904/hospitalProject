<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const prescription = {
			pssn: document.getElementById('pssn')?.value,
			medication: document.getElementById('mname')?.value,
			dssn: document.getElementById('dssn')?.value,
			date: document.getElementById('date')?.value
		};
		const response = await fetch('http://localhost:8080/add-prescription', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(prescription)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<div class="container">
	<div class="row justify-content-md-center">
		<div class="col-3">
			<form on:submit={handleSubmit}>
				<div class="form-group">
					<label for="pssn">Patient SSN (###-##-####) </label>
					<input type="text" name="pssn" id="pssn" class="form-control" />
				</div>
				<div class="form-group">
					<label for="mname">Medication Name </label>
					<input type="text" name="mname" id="mname" class="form-control" />
				</div>
				<div class="form-group">
					<label for="dssn">Prescriber SSN (###-##-####)</label>
					<input type="text" name="dssn" id="dssn" class="form-control" />
				</div>
				<div class="form-group">
					<label for="date">Date (DD-MM-YYYY)</label>
					<input type="text" name="date" id="date" class="form-control" />
				</div>

				<button type="submit">Submit</button>
			</form>
		</div>
	</div>
</div>

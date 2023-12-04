<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const procedure = {
			pnum: document.getElementById('pnum')?.value,
			pdate: document.getElementById('pdate')?.value,
			dssn: document.getElementById('dssn')?.value,
			time: document.getElementById('time')?.value,
			description: document.getElementById('description')?.value
		};

		const response = await fetch('http://localhost:8080/record-procedure', {
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

<div class="container">
	<div class="row justify-content-md-center">
		<div class="col-3">
			<form on:submit={handleSubmit}>
				<div class="form-group">
					<label for="pssn">Patient SSN (###-##-####) </label>
					<input type="text" name="pssn" id="pssn" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pnum">Procedure Number </label>
					<input type="text" name="pnum" id="pnum" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pdate">Date (DD-MM-YYYY)</label>
					<input type="text" name="pdate" id="pdate" class="form-control" />
				</div>
				<div class="form-group">
					<label for="dssn">Doctor SSN (###-##-####)</label>
					<input type="text" name="dssn" id="dssn" class="form-control" />
				</div>
				<div class="form-group">
					<label for="time">Time </label>
					<input type="text" name="time" id="time" class="form-control" />
				</div>
				<div class="form-group">
					<label for="description">Description </label>
					<input type="text" name="description" id="description" class="form-control" />
				</div>
				<button type="submit">Submit</button>
			</form>
		</div>
	</div>
</div>

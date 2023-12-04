<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const patient = {
			ssn: document.getElementById('ssn')?.value,
			id: document.getElementById('pid')?.value,
			fname: document.getElementById('fname')?.value,
			minit: document.getElementById('minit')?.value,
			lname: document.getElementById('lname')?.value,
			addressCurrent: document.getElementById('caddress')?.value,
			phoneCurrent: document.getElementById('cphone')?.value,
			addressPermanent: document.getElementById('paddress')?.value,
			phonePermanent: document.getElementById('pphone')?.value,
			condition: document.getElementById('condition')?.value,
			bdate: document.getElementById('bdate')?.value,
			sex: document.getElementById('sex')?.value,
			docPrimary: document.getElementById('dprime')?.value,
			docSecondary: document.getElementById('dsec')?.value
		};

		const response = await fetch('http://localhost:8080/add-patient', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(patient)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<form on:submit={handleSubmit}>
	<div class="form-group">
		<label for="fname">First Name: </label>
		<input type="text" name="fname" id="fname" class="form-control" />
	</div>
	<div class="form-group">
		<label for="minit">Middle Inital: </label>
		<input type="text" name="minit" id="minit" class="form-control" />
	</div>
	<div class="form-group">
		<label for="lname">Last Name: </label>
		<input type="text" name="lname" id="lname" class="form-control" />
	</div>
	<div class="form-group">
		<label for="ssn">Social Security Number (###-##-####): </label>
		<input type="text" name="ssn" id="ssn" class="form-control" />
	</div>
	<div class="form-group">
		<label for="bdate">Date of Birth (DD-MM-YYYY): </label>
		<input type="date" name="bdate" id="bdate" class="form-control" />
	</div>

	<div class="form-group">
		<label for="caddress">Current Address: </label>
		<input type="text" name="caddress" id="caddress" class="form-control" />
	</div>

	<div class="form-group">
		<label for="paddress">Permanent Address: </label>
		<input type="text" name="paddress" id="paddress" class="form-control" />
	</div>

	<div class="form-group">
		<label for="cphone">Current Phone Number (###-###-####): </label>
		<input type="text" name="cphone" id="cphone" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pphone">Permanent Phone Number (###-###-####): </label>
		<input type="text" name="pphone" id="pphone" class="form-control" />
	</div>
	<div class="form-group">
		<label for="sex">Sex: </label>
		<input type="text" name="sex" id="sex" class="form-control" />
	</div>
	<div class="form-group">
		<label for="condition">Condition: </label>
		<input type="text" name="condition" id="condition" class="form-control" />
	</div>
	<div class="form-group">
		<label for="dprime">Primary Doctor SSN (###-##-####): </label>
		<input type="text" name="dprime" id="dprime" class="form-control" />
	</div>
	<div class="form-group">
		<label for="dsec">Secondary Doctor SSN (###-##-####): </label>
		<input type="text" name="dsec" id="dsec" class="form-control" />
	</div>
	<div class="form-group">
		<label for="pid">Patient ID (P########): </label>
		<input type="text" name="pid" id="pid" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

<style>
	.row {
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>

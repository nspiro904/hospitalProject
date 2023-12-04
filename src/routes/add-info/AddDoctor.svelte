<script lang="ts">
	async function handleSubmit(e: SubmitEvent) {
		const doctor = {
			ssn: document.getElementById('ssn')?.value,
			did: document.getElementById('did')?.value,
			fname: document.getElementById('ssn')?.value,
			minit: document.getElementById('minit')?.value,
			lname: document.getElementById('lname')?.value,
			address: document.getElementById('address')?.value,
			phone: document.getElementById('phone')?.value,
			phoneContact: document.getElementById('phoneContact')?.value,
			bdate: document.getElementById('bdate')?.value,
			department: document.getElementById('department')?.value
		};

		const response = await fetch('http://localhost:8080/add-doctor', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(doctor)
		}).then(() => {
			alert('Successfully Added');
			e.target.reset();
		});
	}
</script>

<form on:submit={handleSubmit}>
	<div class="form-group">
		<label for="ssn">Social Security Number: </label>
		<input type="text" name="ssn" id="ssn" class="form-control" />
	</div>

	<div class="form-group">
		<label for="did">Doctor ID (D########): </label>
		<input type="text" name="did" id="did" class="form-control" />
	</div>
	<div class="form-group">
		<label for="fname">First Name: </label>
		<input type="text" name="fname" id="fname" class="form-control" />
	</div>
	<div class="form-group">
		<label for="minit">Middle Initial: </label>
		<input type="text" name="minit" id="minit" class="form-control" />
	</div>
	<div class="form-group">
		<label for="lname">Last Name: </label>
		<input type="text" name="lname" id="lname" class="form-control" />
	</div>
	<div class="form-group">
		<label for="bdate">Date of Birth (MM-DD-YYYY): </label>
		<input type="text" name="bdate" id="bdate" class="form-control" />
	</div>
	<div class="form-group">
		<label for="phone">Phone Number (###-###-####): </label>
		<input type="text" name="phone" id="phone" class="form-control" />
	</div>
	<div class="form-group">
		<label for="phoneContact">Contact Phone Number (###-###-####): </label>
		<input type="text" name="phoneContact" id="phoneContact" class="form-control" />
	</div>
	<div class="form-group">
		<label for="address">Address: </label>
		<input type="text" name="address" id="address" class="form-control" />
	</div>
	<div class="form-group">
		<label for="department">Department Code: </label>
		<input type="text" name="department" id="department" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">submit</button>
</form>

<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {
		
		const doctor = {
			ssn: document.getElementById("ssn")?.value,
			did: document.getElementById("did")?.value,
			fname: document.getElementById("ssn")?.value,
			minit: document.getElementById("minit")?.value,
			lname: document.getElementById("lname")?.value,
			address: document.getElementById("address")?.value,
			phone: document.getElementById("phone")?.value,
			phoneContact: document.getElementById("phoneContact")?.value,
			bdate: document.getElementById("bdate")?.value,
			department: document.getElementById("department")?.value,
		}

		const response = await fetch("http://localhost:8080/add-doctor", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(doctor)
		});
	}
</script>

<form action="">
	<label for="ssn">Social Security Number: </label>
	<input type="text" name="ssn" id="ssn" />

	<label for="did">Doctor ID: </label>
	<input type="text" name="did" id="did" />

	<label for="fname">First Name: </label>
	<input type="text" name="fname" id="fname" />

	<label for="minit">Middle Initial: </label>
	<input type="text" name="minit" id="minit" />

	<label for="lname">Last Name: </label>
	<input type="text" name="lname" id="lname" />

	<label for="bdate">Date of Birth: </label>
	<input type="text" name="bdate" id="bdate" />

	<label for="phone">Phone Number: </label>
	<input type="text" name="phone" id="phone" />

	<label for="phoneContact">Contact Phone Number: </label>
	<input type="text" name="phoneContact" id="phoneContact" />

	<label for="address">Address: </label>
	<input type="text" name="address" id="address" />

	<label for="department">Department: </label>
	<input type="text" name="department" id="department" />
	<button type="submit" class="btn btn-primary">submit</button>
</form>

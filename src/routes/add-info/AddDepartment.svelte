<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {

		const department = {
			dcode: document.getElementById("dcode")?.value,
			name: document.getElementById("dname")?.value,
			officePhone: document.getElementById("dphone")?.value,
			officeNumber: document.getElementById("dnum")?.value,
			officeHead: document.getElementById("dhead")?.value
		}

		const response = await fetch("http://localhost:8080/add-department", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(department)
		});
	}
</script>

<form action="" id="form">
	<label for="dcode">Code: </label>
	<input type="text" name="dcode" id="dcode" />

	<label for="dname">Name: </label>
	<input type="text" name="dname" id="dname" />

	<label for="dnum">Office Number: </label>
	<input type="text" name="dnum" id="dnum" />

	<label for="dphone">Office Phone: </label>
	<input type="text" name="dphone" id="dphone" />

	<label for="dhead">Head Doctor: </label>
	<input type="text" name="dhead" id="dhead" />

	<button type="submit" class="btn btn-primary">submit</button>
</form>

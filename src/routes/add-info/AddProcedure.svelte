<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {
		
		const procedure = {
			procNum: document.getElementById("pnum")?.value,
			name: document.getElementById("pname")?.value,
			description: document.getElementById("pdes")?.value,
			offeredBy: document.getElementById("pdep")?.value,
			duration: document.getElementById("")?.value,
		}

		const response = await fetch("http://localhost:8080/add-procedure", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(procedure)
		});
	}
</script>

<form action="">
	<label for="pnum">Procedure Number: </label>
	<input type="text" name="pnum" id="pnum" />

	<label for="pname">Name: </label>
	<input type="text" name="pname" id="pname" />

	<label for="pdep">Department: </label>
	<input type="text" name="pdep" id="pdep" />

	<label for="pdes">Description: </label>
	<input type="text" name="pdes" id="pdes" />

	<label for="pdur">Duration: </label>
	<input type="text" name="pdur" id="pdur" />

	<button type="submit" class="btn btn-primary">submit</button>
</form>

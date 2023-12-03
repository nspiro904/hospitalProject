<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {
		

		const medication = {
			name: document.getElementById("mname")?.value,
			manufacturer: document.getElementById("mmanu")?.value,
			description: document.getElementById("mdes")?.value,
		}

		const response = await fetch("http://localhost:8080/add-medication", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(medication)
		});
	}
</script>

<form action="">
	<label for="mname">Name: </label>
	<input type="text" name="mname" id="mname" />

	<label for="mmanu">Manufacturer: </label>
	<input type="text" name="mmanu" id="mmanu" />

	<label for="mdes">Description: </label>
	<input type="textbox" name="mdes" id="mdes" />

	<button type="submit" class="btn btn-primary">submit</button>
</form>

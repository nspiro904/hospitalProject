
<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {
		

		const interaction = {
			pssn: document.getElementById("ipatient")?.value,
			id: document.getElementById("iid")?.value,
			date: document.getElementById("idate")?.value,
			description: document.getElementById("ides")?.value,
			time: document.getElementById("itime")?.value,
		}
		
		const response = await fetch("http://localhost:8080/add-interaction", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(interaction)
		});
	}
</script>

<form action="">
	<label for="ipatient">Patient: </label>
	<input type="text" name="ipatient" id="ipatient" />

	<label for="iid">Interaction ID: </label>
	<input type="text" name="iid" id="iid" />

	<label for="idate">Date: </label>
	<input type="date" name="ddate" id="ddate" />

	<label for="itime">Time: </label>
	<input type="text" name="itime" id="itime" />

	<label for="ides">Description: </label>
	<input type="textbox" name="ides" id="ides" />
	<button type="submit" class="btn btn-primary">submit</button>
</form>

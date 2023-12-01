<script lang="ts">
	let record;
	async function handleSubmit() {
		const pid = document.getElementById('pid')?.value;
		const response = await fetch(`http://localhost:8080/patient-record?id=${pid}`, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});
		record = await response.json();
	}
</script>

<form on:submit={handleSubmit}>
	<label for="pid">Patient ID: </label>
	<input type="text" name="pid" id="pid" />
	<button type="submit">Search</button>
</form>

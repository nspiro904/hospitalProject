<script lang="ts">
	let record;
	async function handleSubmit() {
		const dcode = document.getElementById('dcode')?.value;
		const response = await fetch(`http://localhost:8080/get-procedures-code?dcode=${dcode}`, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});
		record = await response.json();
	}
</script>

<form on:submit={handleSubmit}>
	<label for="dcode">Department Code </label>
	<input type="text" name="dcode" id="dcode" />
	<button type="submit">Search</button>
</form>

{#if record}
	<table>
		<th>Procedure Name</th>
		<th>Number</th>

		{#each record as r}
			<tr>
				<td>{r.name}</td>
				<td>{r.procNum}</td>
			</tr>
		{/each}
	</table>
{/if}

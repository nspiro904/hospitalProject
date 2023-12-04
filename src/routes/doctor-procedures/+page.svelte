<script lang="ts">
	let record;

	async function handleSubmit(e: SubmitEvent) {
		const did = document.getElementById('did')?.value;

		const response = await fetch(`http://localhost:8080/doctor-procedures?did=${did}`, {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json'
			}
		});
		record = await response.json();
	}
</script>

<form on:submit={handleSubmit}>
	<label for="did">Doctor ID </label>
	<input type="text" name="did" id="did" />
	<button type="submit">Search</button>
</form>

{#if record}
	<table>
		<th>Procedure</th>
		<th>Code</th>
		{#each record as r}
			<tr>
				<td>{r.pcode}</td>
				<td>{r.pname}</td>
			</tr>
		{/each}
	</table>
{/if}

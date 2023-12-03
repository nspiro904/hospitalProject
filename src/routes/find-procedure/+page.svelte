<script lang="ts">
let record
async function handleSubmit() {
    
    const dcode = document.getElementById("dcode");
    const response = await fetch(`http://localhost:8080/get-procedures-code?id=${dcode}`, {
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
    <input type="text" name="dcode" id="dcode">
    <button type="submit">Search</button>
</form>

{#if record}
     
<table>
    <th>Procedure Name</th>
    <th>Number</th>
    
    {#each record as r}
    <tr>
        <td>{r.pname}</td>
        <td>{r.pnum}</td>
    </tr>
    {/each}
</table>

{/if}

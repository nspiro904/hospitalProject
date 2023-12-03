<script lang="ts">

let record;

    async function handleSubmit(e: SubmitEvent) {

        const did = document.getElementById("did");

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

<lable for="did">Doctor ID </lable>
<input type="text" name="did" id="did">
<button type="submit">Search</button>
</form>

{#if record}
    <th>Procedure</th>
    <th>Date</th>
    <th>Doctor</th>
    <th>Time</th>
    <th>Description</th>
    {#each record as r}
    <tr>
        <td>{r.pnum}</td>
        <td>{r.pdate}</td>
        <td>{r.dssn}</td>
        <td>{r.time}</td>
        <td>{r.description}</td>
    </tr>
    {/each}
{/if}
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

{#if record}
	<table>
		<tr>
			<th>Name</th>
			<th>Current Address</th>
			<th>Current Phone Number</th>
			<th>Primary Doctor</th>
		</tr>
		<tr>
			<td>{record.patient.fname} {record.patient.minit} {record.patient.lname}</td>
			<td>{record.patient.addressCurrent}</td>
			<td>{record.patient.phoneCurrent}</td>
			<td>{record.patient.docPrimary}</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>Procedure</th>
			<th>Date</th>
		</tr>

		{#each record.procedures as proc}
			<tr>
				<td>{proc.procedure}</td>
				<td>{proc.pdate}</td>
			</tr>
		{/each}
	</table>

	<table>
		<tr>
			<th>Date</th>
			<th>Details</th>
		</tr>

		{#each record.interactions as i}
			<tr>
				<td>{i.date}</td>
				<td>{i.description}</td>
			</tr>
		{/each}
	</table>

	<table>
		<tr>
			<th>Medication</th>
			<th>Date</th>
			<th>Prescriber</th>
		</tr>

		{#each record.scripts as s}
			<tr>
				<td>{s.medication}</td>
				<td>{s.date}</td>
				<td>{s.prescriber}</td>
			</tr>
		{/each}
	</table>
{/if}

<script lang="ts">
	export let data;
</script>

<form>
	<label for="pid">Patient ID: </label>
	<input type="text" name="pid" id="pid" />
	<button type="submit">Search</button>
</form>

{#if data}
	<table>
		<tr>
			<th>Name</th>
			<th>Current Address</th>
			<th>Current Phone Number</th>
			<th>Primary Doctor</th>
		</tr>
		<tr>
			<td>{data.patient.fname} {data.patient.minit} {data.patient.lname}</td>
			<td>{data.patient.addressCurrent}</td>
			<td>{data.patient.phoneCurrent}</td>
			<td>{data.patient.docPrimary}</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>Procedure</th>
			<th>Date</th>
		</tr>

		{#each data.procedures as proc}
			<tr>
				<td>{proc.pnum}</td>
				<td>{proc.pdate}</td>
			</tr>
		{/each}
	</table>

	<table>
		<tr>
			<th>Date</th>
			<th>Details</th>
		</tr>

		{#each data.interactions as i}
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
			<th>Prescriber SSN</th>
		</tr>

		{#each data.scripts as s}
			<tr>
				<td>{s.medication}</td>
				<td>{s.date}</td>
				<td>{s.dssn}</td>
			</tr>
		{/each}
	</table>
{/if}

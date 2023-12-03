<script lang="ts">

    async function handleSubmit(e: SubmitEvent) {

        const prescription = {
            pssn: document.getElementById("pssn")?.value,
            medication: document.getElementById("mname")?.value,
            dssn: document.getElementById("dssn")?.value,
            date: document.getElementById("date")?.value,
        }
        const response = await fetch("http://localhost:8080/add-prescription", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(prescription)
		});
    }
</script>

    <form on:submit={handleSubmit}>
        <label for="pssn">Patient SSN </label>
        <input type="text" name="pssn" id="pssn">

        <label for="mname">Medication Name </label>
        <input type="text" name="mname" id="mname">

        <label for="dssn">Prescriber SSN </label>
        <input type="text" name="dssn" id="dssn">

        <label for="date">Date </label>
        <input type="text" name="date" id="date">

        <button type="submit">Submit</button>
    </form>


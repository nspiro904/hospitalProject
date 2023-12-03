<script lang="ts">

    async function handleSubmit(e: SubmitEvent) {

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


<script lang="ts">


async function handleSubmit(e: SubmitEvent) {
        
    const procedure = {
                pnum: document.getElementById("pnum")?.value,
                pdate: document.getElementById("pdate")?.value,
                dssn: document.getElementById("dssn")?.value,
                time: document.getElementById("time")?.value,
                description: document.getElementById("description")?.value,
            }   

const response = await fetch("http://localhost:8080/record-procedure", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(procedure)
		});

    }
</script>

<form on:submit={handleSubmit}>

    <label for="pnum">Procedure Number </label>
    <input type="text" name="pnum" id="pnum">

    <label for="pdate">Date </label>
    <input type="text" name="pdate" id="pdate">

    <label for="dssn">Doctor SSN </label>
    <input type="text" name="dssn" id="dssn">

    <label for="time">Time </label>
    <input type="text" name="time" id="time">

    <label for="description">Description </label>
    <input type="text" name="description" id="description">

</form>
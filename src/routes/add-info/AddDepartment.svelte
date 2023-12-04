<script lang="ts">
	export let data;

	$: console.log(data);

	// async function handleSubmit(e: SubmitEvent) {
	// 	const department = {
	// 		dcode: document.getElementById('dcode')?.value,
	// 		name: document.getElementById('dname')?.value,
	// 		officePhone: document.getElementById('dphone')?.value,
	// 		officeNumber: document.getElementById('dnum')?.value,
	// 		officeHead: document.getElementById('dhead')?.value
	// 	};

	// 	const response = await fetch('http://localhost:8080/add-department', {
	// 		method: 'POST',
	// 		headers: {
	// 			'Content-Type': 'application/json'
	// 		},
	// 		body: JSON.stringify(department)
	// 	}).then(() => {
	// 		alert('Successfully Added');
	// 		e.target.reset();
	// 	});
	// }
</script>

<form action="?/addDepartment" id="form">
	<div class="form-group">
		<label for="dcode">Code: </label>
		<input type="text" name="dcode" id="dcode" class="form-control" />
	</div>

	<div class="form-group">
		<label for="dname">Name: </label>
		<input type="text" name="dname" id="dname" class="form-control" />
	</div>

	<div class="form-group">
		<label for="dnum">Office Number: </label>
		<input type="text" name="dnum" id="dnum" class="form-control" />
	</div>

	<div class="form-group">
		<label for="dphone">Office Phone (###-###-####): </label>
		<input type="text" name="dphone" id="dphone" class="form-control" />
	</div>

	<div class="form-group">
		<label for="dhead">Head Doctor SSN (###-##-####): </label>
		<input type="text" name="dhead" id="dhead" class="form-control" />
	</div>

	<button type="submit" class="btn btn-primary">Submit</button>
</form>

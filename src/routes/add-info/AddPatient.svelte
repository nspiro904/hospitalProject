<script lang="ts">

	async function handleSubmit(e: SubmitEvent) {
		
		const patient = {
			ssn: document.getElementById("ssn")?.value,
			id: document.getElementById("pid")?.value,
			fname: document.getElementById("fname")?.value,
			minit: document.getElementById("minit")?.value,
			lname: document.getElementById("lname")?.value,
			addressCurrent: document.getElementById("caddress")?.value,
			phoneCurrent: document.getElementById("cphone")?.value,
			addressPermanent: document.getElementById("paddress")?.value,
			phonePermanent: document.getElementById("pphone")?.value,
			condition: document.getElementById("condition")?.value,
			bdate: document.getElementById("bdate")?.value,
			sex: document.getElementById("sex")?.value,
			docPrimary: document.getElementById("dprime")?.value,
			docSecondary: document.getElementById("dsec")?.value,
		}

		const response = await fetch("http://localhost:8080/add-patient", {
			method: "POST",
			headers: {
				"Content/Type": "application/json"
			},
			body: JSON.stringify(patient)
		});
	}
</script>

<div class="container">
	<form action="addPatient">
		<div class="row">
			<div class="col-5">
				<label for="fname">First Name: </label>
			</div>
			<div class="col-6">
				<input type="text" name="fname" id="fname" />
			</div>
		</div>
		<div class="row">
			<div class="col-5">
				<label for="minit">Middle Inital: </label>
			</div>
			<div class="col-6">
				<input type="text" name="minit" id="minit" />
			</div>
			<div class="row">
				<div class="col-5">
					<label for="lname">Last Name: </label>
				</div>
				<div class="col-6">
					<input type="text" name="lname" id="lname" />
				</div>

				<div class="row">
					<div class="col-5">
						<label for="ssn">Social Security Number: </label>
					</div>
					<div class="col-6">
						<input type="text" name="ssn" id="ssn" />
					</div>

					<div class="row">
						<div class="col-5">
							<label for="bdate">Date of Birth: </label>
						</div>
						<div class="col-6">
							<input type="date" name="bdate" id="bdate" />
						</div>
					</div>

					<label for="caddress">Current Address: </label>
					<input type="text" name="caddress" id="caddress" />

					<label for="paddress">Permanent Address: </label>
					<input type="text" name="paddress" id="paddress" />

					<label for="cphone">Current Phone Number: </label>
					<input type="text" name="cphone" id="cphone" />

					<label for="pphone">Permanent Phone Number: </label>
					<input type="text" name="pphone" id="pphone" />

					<label for="sex">Sex: </label>
					<input type="text" name="sex" id="sex" />

					<label for="condition">Condition: </label>
					<input type="text" name="condition" id="condition" />

					<label for="dprime">Primary Doctor: </label>
					<input type="text" name="dprime" id="dprime" />

					<label for="dsec">Secondary Doctor: </label>
					<input type="text" name="dsec" id="dsec" />

					<label for="pid">Patient ID: </label>
					<input type="text" name="pid" id="pid" />
					<div class="row">
						<div class="col-6">
							<button type="submit" class="btn btn-primary">submit</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<style>
	.row {
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>

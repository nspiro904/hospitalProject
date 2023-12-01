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

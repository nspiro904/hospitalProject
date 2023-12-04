<script lang="ts">
	import Dialog from '$lib/Dialog.svelte';
	import AddDepartment from './AddDepartment.svelte';
	import AddDoctor from './AddDoctor.svelte';
	import AddInteraction from './AddInteraction.svelte';
	import AddMedication from './AddMedication.svelte';
	import AddPatient from './AddPatient.svelte';
	import AddProcedure from './AddProcedure.svelte';
	let dialogPatient: HTMLDialogElement;
	let dialogDepartment: HTMLDialogElement;
	let dialogDoctor: HTMLDialogElement;
	let dialogInteraction: HTMLDialogElement;
	let dialogMedication: HTMLDialogElement;
	let dialogProcedure: HTMLDialogElement;
</script>

<Dialog bind:dialog={dialogPatient} label="">
	<AddPatient />
</Dialog>

<Dialog bind:dialog={dialogDepartment} label="">
	<AddDepartment />
</Dialog>

<Dialog bind:dialog={dialogDoctor} label="">
	<AddDoctor />
</Dialog>

<Dialog bind:dialog={dialogInteraction} label="">
	<AddInteraction />
</Dialog>

<Dialog bind:dialog={dialogMedication} label="">
	<AddMedication />
</Dialog>

<Dialog bind:dialog={dialogProcedure} label="">
	<AddProcedure />
</Dialog>

<div class="container-sm">
	<div class="btn-group-vertical align-self-center" role="group">
		<button
			on:click={() => dialogPatient.showModal()}
			type="button"
			class="btn btn-primary btn-large">Add Patient</button
		>
		<button on:click={() => dialogDoctor.showModal()} type="button" class="btn btn-primary"
			>Add Doctor</button
		>
		<button on:click={() => dialogDepartment.showModal()} type="button" class="btn btn-primary"
			>Add Department</button
		>
		<button on:click={() => dialogProcedure.showModal()} type="button" class="btn btn-primary"
			>Add Procedure</button
		>
		<button on:click={() => dialogMedication.showModal()} type="button" class="btn btn-primary"
			>Add Medication</button
		>
		<button on:click={() => dialogInteraction.showModal()} type="button" class="btn btn-primary"
			>Add Interaction Record</button
		>
	</div>
</div>

<style>
	button,
	a {
		margin-top: 10px;
		margin-bottom: 10px;
		width: 300% !important;
	}

	.margins {
		margin-top: 20%;
	}
</style>

<script lang="ts">
	import { createEventDispatcher } from 'svelte';

	export let dialog: HTMLDialogElement;
	export let label = 'Open Dialog';
	const dispatch = createEventDispatcher();
	function open(e: any) {
		dialog.showModal();
		dispatch('show');
	}

	function close(e: MouseEvent) {
		const dialog = e.target as HTMLDialogElement;
		// skip if the click was on some other element
		if (dialog.tagName !== 'DIALOG') return;
		// close by clicking on the dialog::backdrop
		// credit: https://stackoverflow.com/questions/25864259/how-to-close-the-new-html-dialog-tag-by-clicking-on-its-backdrop
		const rect = dialog.getBoundingClientRect();
		const isInDialog =
			rect.top <= e.clientY &&
			e.clientY <= rect.top + rect.height &&
			rect.left <= e.clientX &&
			e.clientX <= rect.left + rect.width;
		if (!isInDialog) {
			dialog.close();
		}
	}
</script>

<!-- svelte-ignore a11y-click-events-have-key-events -->
<span on:click={open}>
	{#if label}
		<slot name="trigger">
			<button type="button">{label}</button>
		</slot>
	{/if}
</span>
<!-- svelte-ignore a11y-click-events-have-key-events -->
<dialog bind:this={dialog} on:click={close}>
	<slot />
</dialog>

<style lang="scss">
	dialog {
		padding: 6rem 8rem;
	}
	label {
		color: black;
	}
</style>

import { useTasks } from "../utils/ContextApi";

export default function Form() {
  const { isFormOpen, setIsOpen } = useTasks();

  function handleSubmit() {
    setIsOpen(false);
  }

  return (
    isFormOpen && (
      <form className='form__container' onSubmit={handleSubmit}>
        <div className='form__row'>
          <label htmlFor='taskHeader'>Task Header</label>
          <input type='text' name='taskName' id='taskHeader' />
        </div>
        <div className='form__row'>
          <label htmlFor='task'>Task Content</label>
          <textarea type='text' name='task' id='task' />
        </div>
        <div className='form__row'>
          <label htmlFor='status'>Task Status</label>
          <select name='statusName' id='status'>
            <option value=''></option>
            <option value='Not Started'>Not Started</option>
            <option value='In Progress'>In Progress</option>
            <option value='Done'>Done</option>
          </select>
        </div>
        <div className='form__row'>
          <button type='submit' className='btn__send'>
            Create
          </button>
        </div>
      </form>
    )
  );
}

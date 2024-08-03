import { useTasks } from "../utils/ContextApi";

export default function DeleteModal(id) {
  const { currentTask, isDeleteModalOpen, setDeleteModalOpen } = useTasks();

  function handleDeleteTask() {}

  if (isDeleteModalOpen)
    return (
      <div className="modal__container">
        <div className="modal">
          <p className="delete__text">
            Are you sure about to delete {currentTask.taskName} ?
          </p>
          <div className="modal__footer">
            <button
              className="btn__cancel"
              onClick={() => setDeleteModalOpen((s) => !s)}
            >
              Cancel
            </button>
            <button onClick={() => handleDeleteTask(id)}>Delete</button>
          </div>
        </div>
      </div>
    );
}

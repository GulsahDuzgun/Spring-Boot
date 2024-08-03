import { HiMiniTrash, HiMiniPencilSquare } from "react-icons/hi2";
import { updateTask } from "../utils/service";
import { useTasks } from "../utils/ContextApi";

const statusColors = {
  not_started: "#ff8787",
  in_progress: "#ffd43b",
  done: "#69db7c",
};

export default function TaskItem({ tasks }) {
  const { setIsModalOpen } = useTasks();

  function handleOpenModal(id, stringText, executedFunc) {
    setIsModalOpen((s) => !s);
  }

  return tasks?.map((task, indx) => (
    <li className="task" key={indx}>
      <div className="task__detail">
        <span
          className="task__status"
          style={{
            backgroundColor:
              statusColors[
                `${task?.statusName?.replace(" ", "_").toLowerCase()}`
              ],
          }}
        >
          {task.statusName}
        </span>
        <p className="task__title">{task.taskName}</p>
        <p className="task__text">{task.task}</p>
      </div>
      <div className="task__btn">
        <button onClick={() => handleOpenModal(task.id, "Update", updateTask)}>
          <HiMiniPencilSquare />
        </button>
        <button>
          <HiMiniTrash />
        </button>
      </div>
    </li>
  ));
}

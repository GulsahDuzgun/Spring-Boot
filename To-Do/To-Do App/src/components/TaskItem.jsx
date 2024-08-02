import { HiMiniTrash, HiMiniPencilSquare } from "react-icons/hi2";

export default function TaskItem({ tasks }) {
  return tasks?.map((task, indx) => (
    <li className='task' key={indx}>
      <div className='task--detail'>
        <p className='task--title'>{task.taskName}</p>
        <p className='task--text'>{task.task}</p>
      </div>
      <div className='task--btn'>
        <button>
          <HiMiniPencilSquare />
        </button>
        <button>
          <HiMiniTrash />
        </button>
      </div>
    </li>
  ));
}

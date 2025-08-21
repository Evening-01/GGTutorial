
#include <iostream>
#include <sys/mman.h>
#include <unistd.h>
#include <vector>
#include <chrono>
#include <thread>

#include "log.h"

#include <jni.h>
#include <pthread.h>
#include <unistd.h>
#include <sys/ptrace.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <iostream>

void *memory_check_thread(void *arg) {
    constexpr size_t MAP_SIZE = 0x4000;
    void *mem = mmap(nullptr, MAP_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);
    if (mem == MAP_FAILED) {
        return nullptr;
    }
    auto mem_addr = reinterpret_cast<uintptr_t>(mem);
    void *address = reinterpret_cast<void *>(mem_addr - (mem_addr % PAGE_SIZE));
    LOGD("mem: %p, address: %p", mem, address);
    unsigned char state;
    while (true) {
        if (mincore(address, PAGE_SIZE, &state) != 0) {
            munmap(mem, MAP_SIZE);
            return nullptr;
        }
        LOGD("address: %p, %s", address, (state & 0x1 ? "Mapped" : "Not mapped"));
        std::this_thread::sleep_for(std::chrono::seconds(5));
    }
    munmap(mem, MAP_SIZE);
}

void *ptrace_monitor_thread(void *arg) {

    return nullptr;
}
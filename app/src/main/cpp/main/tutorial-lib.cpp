#include <jni.h>
#include <pthread.h>
#include "test.h"

pthread_t g_thread;

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
//    if (pthread_create(&g_thread, nullptr, memory_check_thread, nullptr) != 0) {
//        return JNI_ERR;
//    }
    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
//    pthread_join(g_thread, nullptr);
}

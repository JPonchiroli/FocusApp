# FocusApp

## Ideia

Aplicativo Android para ajudar o usuário a controlar o uso de
aplicativos que causam distração.

No MVP, o foco será apenas no TikTok.

## Proposta

Após selecionar o TikTok para monitoramento:

-   O usuário possui 10 minutos de uso.
-   O tempo é consumido apenas enquanto o aplicativo estiver aberto.
-   Ao atingir 10 minutos, o aplicativo é bloqueado por 1 hora.
-   Após 1 hora, o usuário recebe novamente 10 minutos.
-   O tempo não é acumulativo.

## Regras de negócio

### Ciclo

LIBERADO (10 min) → BLOQUEADO (1 hora) → LIBERADO (10 min)

### Regras

-   O contador pausa quando o TikTok é fechado.
-   O tempo restante é preservado.
-   Esperar mais de uma hora não gera tempo extra.
-   Sempre existe apenas um ciclo ativo.

## MVP

-   Seleção do TikTok.
-   Monitoramento em segundo plano.
-   Contador de 10 minutos.
-   Bloqueio por 1 hora.
-   Tela de bloqueio.
-   Persistência local.

## Tecnologias

-   Kotlin
-   Jetpack Compose
-   Material 3
-   MVVM
-   Coroutines + Flow
-   DataStore
-   Room (posteriormente)
-   Hilt (posteriormente)
-   Foreground Service
-   UsageStatsManager
-   AccessibilityService
-   WorkManager (evoluções)

## Estrutura inicial

-   ui/
-   service/
-   monitor/
-   repository/
-   storage/
-   model/
-   util/

## Plano de desenvolvimento

### Sprint 1

-   Criar projeto
-   Estruturar pacotes
-   Tela inicial

### Sprint 2

-   Permissões
-   Usage Access
-   Accessibility
-   Ignorar otimização de bateria

### Sprint 3

-   Foreground Service
-   Detectar app em primeiro plano

### Sprint 4

-   Contador de uso
-   Persistência com DataStore

### Sprint 5

-   Bloqueio por 1 hora

### Sprint 6

-   Tela de bloqueio

### Sprint 7

-   Seleção de aplicativos
-   Preparação para múltiplos apps

## Evoluções futuras

-   Configuração dos tempos
-   Estatísticas
-   Dashboard
-   Pomodoro
-   Desafios
-   Backup
-   Widgets

## Objetivo

Criar um aplicativo Android nativo, simples, robusto e extensível,
priorizando arquitetura limpa e aprendizado progressivo do ecossistema
Android.
